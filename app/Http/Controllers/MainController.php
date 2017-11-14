<?php

namespace App\Http\Controllers;
use Illuminate\Http\Request;
use Illuminate\Support\MessageBag;
use Illuminate\Support\Facades\Redirect;
use Securimage;
use Sentinel;
use View;

class MainController extends Controller
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
    

    /** 
    *
    *
    * @return view
    */
    public function home()
    {
        if(Sentinel::check())
        {
            if(Sentinel::getUser()->inRole('user')){
                return view('user.index');
            }
            elseif (Sentinel::getUser()->inRole('admin')) {

                return view('admin.index');
            }
        }
        else {
            return redirect('login')->with('error','You must be logged in');
        }
    }
    public function showView($name=null){
        if(Sentinel::getUser()->inRole('admin'))
        {
            if(View::exists('admin.'.$name))
            {
                if(Sentinel::check())
                return view('admin.'.$name);
                else
                return redirect('signin')->with('error','You must be logged in');
            }
            else {
                return view('admin.404');
            }
        }
        else
        {
            if(View::exists('user.'.$name))
            {
                if(Sentinel::check())
                return view('user.'.$name);
                else
                return redirect('signin')->with('error','You must be logged in');
            }
            else {
                return view('user.404');
            }
        }
    }

    public function showFrontEndView($name=null){

        if(View::exists($name))
        {
            return view($name);
        }
        else {
            return view('user.404');
        }

    }






    }


