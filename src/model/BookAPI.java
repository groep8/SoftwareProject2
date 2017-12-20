/*
 * Copyright (c) 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package model;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.BooksRequestInitializer;
import com.google.api.services.books.Books.Volumes.List;
import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volumes;

import model.ClientCredentials;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * A sample application that demonstrates how Google Books Client Library for
 * Java can be used to query Google Books. It accepts queries in the command
 * line, and prints the results to the console.
 *
 * $ java com.google.sample.books.BooksSample [--author|--isbn|--title] "<query>"
 *
 * Please start by reviewing the Google Books API documentation at:
 * http://code.google.com/apis/books/docs/getting_started.html
 */
public class BookAPI {

  /**
   * Be sure to specify the name of your application. If the application name is {@code null} or
   * blank, the application will log a warning. Suggested format is "MyCompany-ProductName/1.0".
   */
  private static final String APPLICATION_NAME="API KEY";
  
  //private static final NumberFormat CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance();
  //private static final NumberFormat PERCENT_FORMATTER = NumberFormat.getPercentInstance();

  public static ArrayList<Book> queryGoogleBooks( String[] args) throws Exception {
		 JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
		    int volgnummer=0;
		      // Verify command line parameters.
		     /* if (args.length == 0) {
		        System.err.println("Usage: BooksSample [--author|--isbn|--title] \"<query>\"");
		        System.exit(1);
		      }*/
		      // Parse command line parameters into a query.
		      // Query format: "[<author|isbn|intitle>:]<query>"
		      String prefix = null;
		      ArrayList<Book> result= new ArrayList<Book>();
		    
		     //args = new String[] {"--title", "Harry Potter"};
		      //String query = "<Christopher Paolini|ISBN_13|Eragon\"<query>\"";
		      String query ="";
		      for (String arg : args) {
		        if ("--author".equals(arg)) {
		          prefix = "inauthor:";
		        } else if ("--isbn".equals(arg)) {
		          prefix = "isbn:";
		        } else if ("--title".equals(arg)) {
		          prefix = "intitle:";
		        } else if (arg.startsWith("--")) {
		          //System.err.println("Unknown argument: " + arg);
		          System.exit(1);
		        } else {
		          query = arg;
		        }
		      }
		      if (prefix != null) {
		        query = prefix + query;
		      }
		     
		   
		    
    ClientCredentials.errorIfNotSpecified();
    
    // Set up Books client.
    final Books books = new Books.Builder(GoogleNetHttpTransport.newTrustedTransport(), jsonFactory, null)
        .setApplicationName(APPLICATION_NAME)
        .setGoogleClientRequestInitializer(new BooksRequestInitializer(ClientCredentials.API_KEY))
        .build();
    // Set query string and filter only Google eBooks.
   // System.out.println("Query: [" + query + "]");
  
    List volumesList = books.volumes().list(query);
    volumesList.setFilter("ebooks");

    // Execute the query.
    Volumes volumes = volumesList.execute();
    if (volumes.getTotalItems() == 0 || volumes.getItems() == null) {
      //System.out.println("No matches found.");
    	//result.add("No matches found");
      return result;
    }

    // Output results.
    for (Volume volume : volumes.getItems()) {
      Volume.VolumeInfo volumeInfo = volume.getVolumeInfo();
     // Volume.SaleInfo saleInfo = volume.getSaleInfo();
      //System.out.println("==========");
      // Title.
     // System.out.println("Title: " + volumeInfo.getTitle());
      Book b =new Book();
      b.setBoek(volumeInfo.getTitle());
     // volgnummer++;
// result.add(volgnummer+". "+volumeInfo.getTitle());
      // Author(s).
      java.util.List<String> authors = volumeInfo.getAuthors();
      if (authors != null && !authors.isEmpty()) {
        //System.out.print("Author(s): ");
  
        for (int i = 0; i < authors.size(); ++i) {
          //System.out.print(authors.get(i));
         
          b.setAuteur(authors.get(i));
          result.add(b);
          if (i < authors.size() - 1) {
            //System.out.print(", ");
          }
        }
     
      }
    }
    return result;
  }}
      