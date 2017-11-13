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

class MainController extends Controller
{
    /** 
    *
    *
    * @return view
    */
    public function home()
    {
        return view('admin.index');
    }
    /**
     * 
     * @param Request $request 
     * @return Redirect
     */
   
    }


