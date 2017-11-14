<?php

namespace App\Http\Controllers;
use App\User;
use Cartalyst\Sentinel\Checkpoints\NotActivatedException;
use Cartalyst\Sentinel\Checkpoints\ThrottlingException;
use Cartalyst\Sentinel\Laravel\Facades\Activation;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Redirect;

use Lang;
use Mail;
use Reminder;
use Sentinel;
use URL;
use Validator;
use View;
use MessageBag;

class AuthController extends MainController
{

    

    /*
    *
    *
    * @return view
    */
    public function home()
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
            
    
            
   
            
            $this->messageBag->add('username' ,'Account niet gevonden');
            
        
        
        } 
        catch (NotActivatedException $e) {
            if($e !=null){
                
            $this->messageBag->add('username', 'Account niet geactiveerd');
            }
        }
        catch (ThrottlingException $e) {
            if($e !=null){
                
            $delay = $e->getDelay();
            $this->messageBag->add('username', 'Toegang verboden tot het platform  voor '.$delay.' seconden');
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


