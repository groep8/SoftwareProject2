<?php

namespace App;

use Cartalyst\Sentinel\Users\EloquentUser;
use Illuminate\Database\Eloquent\SoftDeletes;

class User extends EloquentUser
{
   /**
   *
   *
   *
   *
   *@var string
   */

   protected $table = 'users';

    /**
     * The attributes to be fillable from the model.
     *
     *
     * 
     * @var array
     */

    protected $fillable = [
        'name', 'email', 'password','username'
    ];

    /**
     * The attributes that should be hidden for arrays.
     *
     * @var array
     */
    protected $hidden = [
        'password', 'remember_token',
    ];
    /*
    * to allow soft del
    */
    use SoftDeletes;
    
    protected $dates = ['deleted_at'];
    protected $loginNames = ['username'];
}
