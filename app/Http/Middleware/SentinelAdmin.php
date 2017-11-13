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
        if (Sentinel::inRole('manager') or Sentinel::inRole('hrmanager')){
            $tasks_count = Task::where('user_id', Sentinel::getUser()->id)->count();
            $request->attributes->add(['tasks_count' => $tasks_count]);
            
            return $next($request);


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