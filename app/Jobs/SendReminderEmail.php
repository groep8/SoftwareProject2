<?php

namespace App\Jobs;

use App\User;
use App\Jobs\Job;
use Sentinel;
use Illuminate\Bus\Queueable;
use Illuminate\Queue\SerializesModels;
use Illuminate\Queue\InteractsWithQueue;
use Illuminate\Contracts\Queue\ShouldQueue;
use Illuminate\Foundation\Bus\Dispatchable;
use Illuminate\Contracts\Mail\Mailer;

class SendReminderEmail   implements   ShouldQueue
{
    use Dispatchable, InteractsWithQueue, Queueable, SerializesModels;
    
    protected $user;
    /**
     * Create a new job instance.
     *
     * @return void
     */
    public function __construct()
    {
        Sentinel::getUser()->username =$user;
    }

    /**
     * Execute the job.
     *
     * @return void
     */
    public function handle()
    {
        
        $user = Sentinel::getUser()->username ;
        return $this->from('ionut.alazaroae@gmail.Com')
                    ->view('email.template',compact('user'));
    }
}
