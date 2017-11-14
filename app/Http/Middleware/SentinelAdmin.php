<?php

namespace App\Http\Middleware;


use App\Task;
use Closure;
use Sentinel;

class SentinelAdmin{

    /**
    *
    *
    * @param \Illuminate\Http\Request $request
    * @param \Closure $next
    * @return mixed
    */
public function handle($request, Closure $next){





    if (Sentinel::check()){
        if (Sentinel::inRole('admin')){
            
            
            return $next($request);


        }
        elseif (Sentinel::inRole('user')) {
            return response('Unauthorized',401);
        }
        else{
            return redirect()->route('admin.index');
        }

    }
    else{
        return redirect('login')->with('warning','You must be logged in');

    }







}


}