<?php

namespace App\Http\Controllers;
use App\User;
use Cartalyst\Sentinel\Checkpoints\NotActivatedException;
use Cartalyst\Sentinel\Checkpoints\ThrottlingException;
use Cartalyst\Sentinel\Laravel\Facades\Activation;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Redirect;
use Illuminate\Support\MessageBag;

use Lang;
use Mail;
use Reminder;
use Sentinel;
use URL;
use Validator;
use View;

class AuthController extends MainController
{

     /**
     * 
     * 
     * @var Illuminate\Support\MessageBag
     */
    protected $messageBag = null;
    /**
     * 
     * Init
     */
    public function _construct()
        {
            $this->$messageBag = new MessageBag;
        }
    
    /*
    *
    *
    * @return view
    */
    public function getSignin()
    {

        if (Sentinel::check()){
            if (Sentinel::getUser()->inRole('user')){
                return Redirect::route('user.index');


            }

            else {
                return Redirect::route('admin.index');
            }
   
        }
        else {
            return view('login');
        }


    }
    /**
     * 
     * @param Request $request 
     * @return Redirect
     */
    public function postSignin(Request $request)
    {
        try {
            
            
            // Try to log the user in
            if (Sentinel::authenticate($request->only(['username', 'password']))) {
                // Redirect to the dashboard page
                //check if user is admin or customer
                //if user is customer -> user.dashboard else log  > admin.dashboard
                $user=Sentinel::getUser();
               
                if($user->inRole('user')){
                  
                    return Redirect::route("user.index")->with('success', Lang::get('auth/message.signin.success'));
                }
                else {
                    return Redirect::route("admin.index")->with('success', Lang::get('auth/message.signin.success'));
                }                
                
            }
            
    
            
   
            
            $this->messageBag->add('username' ,'doesnt exist');
            
        
        
        } 
        catch (NotActivatedException $e) {
            if($e !=null){
                
            $this->messageBag->add('username', Lang::get('auth/message.account_not_activated'));
            }
        }
        catch (ThrottlingException $e) {
            if($e !=null){
                dd($e);
            $delay = $e->getDelay();
            $this->messageBag->add('username', Lang::get('auth/message.account_suspended', compact('delay')));
        }}
        // Ooops.. something went wrong
        return Redirect::back()->withInput()->withErrors($this->messageBag);
    }
    /**
     * 
     * @return Redirect
     */
    public function getLogout(){

        Sentinel::logout;
        return redirect('../login')->with('success','logged out');

    }
    }


