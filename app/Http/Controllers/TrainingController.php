<?php

namespace App\Http\Controllers;
use Illuminate\Http\Request;
use Illuminate\Support\MessageBag;
use Illuminate\Support\Facades\Redirect;
use Securimage;
use Sentinel;
use View;
use PDO;
use Response;
use App\Http\Requests\TrainingConfirmRequest;
use App\Http\Requests\TrainingUndoRequest;
use Illuminate\Support\Collection;



class TrainingController extends Controller
{


    /**
     * 
     * 
     * @var Illuminate\Contracts\Support\MessageBag
     */
    protected $messageBag = null;
    /**
     * 
     * Initializer.
     */
    public function __construct()
        {
            $this->messageBag = new MessageBag;
           
        }
    

    /** 
    *
    *
    * @return view
    */
   
    

    public function getPending(){

        $query="SELECT id,naamTraining,naamEmployee,adres,datum FROM confirmations WHERE confirmed_at IS NULL";
        try {
            $conn = new PDO("mysql:host=localhost;dbname=soft2", "root","");
            $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            $stmt = $conn->prepare($query); 
            $stmt->execute();
        
            // set the resulting array to associative
            $test = $stmt->setFetchMode(PDO::FETCH_ASSOC); 
            $test = $stmt->fetchAll();
            $collection = new Collection();        
            $count = count($test);
    
            for ($i = 0; $i < $count ; $i++) { 
                
            $id = (string)$test[$i]["id"]; 
            $naamTraining = (string)$test[$i]["naamTraining"];
            $adres = (string)$test[$i]["adres"];
            $datum = (string)$test[$i]["datum"];
            $naamEmployee = (string)$test[$i]["naamEmployee"];
           
            
    
            $collection->push([
                'id' => $id,
                'naamTraining' => $naamTraining,
                'adres' => $adres,
                'datum' => $datum,
                'naamEmployee' => $naamEmployee
                ]);
    
            }
            
                return $collection->toJson();
            
            
        }
        catch(PDOException $e) {
            echo "Error: " . $e->getMessage();
        }
        $conn = null;
        
    
      
    

    }

    public function getConfirmed(){
        
                $query="SELECT id,naamTraining,naamEmployee,adres,datum FROM confirmations WHERE confirmed_at IS NOT NULL";
                try {
                    $conn = new PDO("mysql:host=localhost;dbname=soft2", "root","");
                    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
                    $stmt = $conn->prepare($query); 
                    $stmt->execute();
                
                    // set the resulting array to associative
                    $test = $stmt->setFetchMode(PDO::FETCH_ASSOC); 
                    $test = $stmt->fetchAll();
                    $collection = new Collection();        
                    $count = count($test);
            
                    for ($i = 0; $i < $count ; $i++) { 
                        
                    $id = (string)$test[$i]["id"]; 
                    $naamTraining = (string)$test[$i]["naamTraining"];
                    $adres = (string)$test[$i]["adres"];
                    $datum = (string)$test[$i]["datum"];
                    $naamEmployee = (string)$test[$i]["naamEmployee"];
                   
                    
            
                    $collection->push([
                        'id' => $id,
                        'naamTraining' => $naamTraining,
                        'adres' => $adres,
                        'datum' => $datum,
                        'naamEmployee' => $naamEmployee
                        ]);
            
                    }
                    
                        return $collection->toJson();
                    
                    
                }
                catch(PDOException $e) {
                    echo "Error: " . $e->getMessage();
                }
                $conn = null;
                
            
              
            
        
            }
    public function postTraining(TrainingConfirmRequest $request ){
        $id = $request->id;
        $now = date ('Y-m-d H:i:s', time());
        $dbh = new PDO ( "mysql:host=localhost;dbname=soft2", "root","" );
        $stmt = $dbh->prepare ( 'UPDATE confirmations SET confirmed_at = :sql_confirmed  WHERE id=:sql_id' );
        $stmt->bindParam ( ':sql_confirmed', $now);
        $stmt->bindParam ( ':sql_id', $id );
        $stmt->execute ();
        return Response::json(200);   
    
        


    }
    public function postUndo(TrainingUndoRequest $request ){
        $id = $request->id;
        $now = null;
        $dbh = new PDO ( "mysql:host=localhost;dbname=soft2", "root","" );
        $stmt = $dbh->prepare ( 'UPDATE confirmations SET confirmed_at = :sql_confirmed  WHERE id=:sql_id' );
        $stmt->bindParam ( ':sql_confirmed', $now);
        $stmt->bindParam ( ':sql_id', $id );
        $stmt->execute ();
        return Response::json(200);   
    
        


    }
}
