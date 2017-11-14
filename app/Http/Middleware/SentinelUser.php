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




    if(Sentinel::check()){
        if (Sentinel::inRole('user')){
            
            
            
            return $next($request);


        }
        elseif (Sentinel::inRole('admin')) {
            return response('Unauthorized',401);
        }
        else{
            return redirect()->route('user.index');
        }
    }
    else{
        return redirect('login')->with('warning','You must be logged in');

    }







}

}


