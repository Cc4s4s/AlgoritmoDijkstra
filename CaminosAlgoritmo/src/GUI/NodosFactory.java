/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package GUI;

import java.util.ArrayList;

/**
 * @author Salvador Vera Franco 
 *  NodosFactory class 1.0
 */

public class NodosFactory {
    
    private static final ArrayList<Nodos> listnodos=new ArrayList<>();
 
    public static Nodos addNodo(String idNodo,int x,int y){
        Nodos n=new Nodos(idNodo,x,y);
        if(!IDexist(idNodo)){
            listnodos.add(n);
            return n;
        }
        else 
            return null;
    }

    public static Nodos addNodo(Nodos nodo){
        if(!IDexist(nodo.getID())){
            listnodos.add(nodo);
            return nodo;
        }
        else 
            return null;
    }
    
    public static ArrayList<Nodos> getListaNodos(){
        return listnodos;   
    }
    
    public static Nodos getNodo(String idNodo){
        Nodos nodo=null; 
         for(int n=0;n<listnodos.size();n++){
            if(listnodos.get(n).getID().equals(idNodo)){
                nodo=listnodos.get(n);
                break;
            }
        }
        return nodo;
    }
    
    public static boolean IDexist(String id){
        return getNodo(id)!=null;
    }

}
