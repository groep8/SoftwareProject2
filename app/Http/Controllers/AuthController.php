<?php

namespace App\Http\Controllers;
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

class AuthController extends BaseController
{
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
    public function postSignIn(Request $request)
    {

            if(Sentinel::authenticate($request->only(['username','password']),$request->get('remember-me',false))){

                $user = Sentinel::getUser();
                if($user->inRole('user')){
                    return Redirect::route("user.index");
                }
                else {
                    return Redirect::route("admin.index");
                }


            }




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


