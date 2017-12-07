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
use App\Http\Requests\TrainingAddRequest;
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

        $query="SELECT id,naamTraining,naamEmployee,adres,datum,begin FROM confirmations WHERE confirmed_at IS NULL";
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
            $start = (string)$test[$i]["begin"];
            
    
            $collection->push([
                'id' => $id,
                'naamTraining' => $naamTraining,
                'adres' => $adres,
                'datum' => $datum,
                'naamEmployee' => $naamEmployee,
                'start' => $start
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
        
                $query="SELECT id,naamTraining,naamEmployee,adres,datum,begin FROM confirmations WHERE confirmed_at IS NOT NULL";
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
                    $start = (string)$test[$i]["begin"];
                    
                    
            
                    $collection->push([
                        'id' => $id,
                        'naamTraining' => $naamTraining,
                        'adres' => $adres,
                        'datum' => $datum,
                        'naamEmployee' => $naamEmployee,
                        'start' => $start
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
    public function postRequests(TrainingAddRequest $request){

        $user  = Sentinel::getUser()->username;
        $date = $request->date;
        $timenow = date("Y-m-d");
        $training  = $request->training;
        $db = new PDO ( "mysql:host=localhost;dbname=soft2", "root","" );
        $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        $sql = "INSERT INTO confirmations(naamTraining,naamEmployee,datum,begin) VALUES (:sql_naamTraining ,:sql_naamEmployee , :sql_datum,:sql_begin)";
        $stmt = $db->prepare($sql);
        $stmt->bindParam ( ':sql_naamTraining', $training);
        $stmt->bindParam ( ':sql_naamEmployee', $user);
        $stmt->bindParam ( ':sql_datum', $timenow );
        $stmt->bindParam ( ':sql_begin', $date);
        $stmt->execute();
        $db = null;
        return "success";
        
        
    }
    public function getrequests(){
        $user  = Sentinel::getUser()->username;
        $query="SELECT id,naamTraining,naamEmployee,adres,datum,confirmed_at,begin FROM confirmations WHERE naamEmployee ='".$user."'";
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
            $status = null;
            if((string)$test[$i]["confirmed_at"] == null){
                $status = "<p style='color:red'>Pending</p>";
            }
            else{
                $status = "Confirmed at ".(string)$test[$i]["confirmed_at"]; 
            }
            $start = (string)$test[$i]["begin"];
            
           
            
    
            $collection->push([
                'id' => $id,
                'naamTraining' => $naamTraining,
                'adres' => $adres,
                'datum' => $datum,
                'naamEmployee' => $naamEmployee,
                'status' =>$status,
                'start' =>$start
                ]);
    
            }
            
                return $collection->toJson();
            
            
        }
        catch(PDOException $e) {
            echo "Error: " . $e->getMessage();
        }
        $conn = null;
        
    
      
    
    }
}
