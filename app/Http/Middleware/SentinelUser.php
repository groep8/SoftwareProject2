<?php

namespace App\Http\Middleware;


use App\Task;
use Closure;
use Sentinel;

class SentinelUser{

    /**
    *
    *
    * @param \Illuminate\Http\Request $request
    * @param \Closure $next
    * @return mixed
    */
public function handle($request, Closure $next){





    if (Sentinel::check()){
        if ($request->ajax()){
            return response('Unauthorized',401);
        }
        else{
            return redirect()->route('login');
        }
    }
    if(Sentinel::inRole('user'))
        return redirect()->route('user.home.index');
    

    }







}


