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
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Salvador Vera Franco 
 *  OSPF class 1.1
 */

public class OSPF {
    public static String Nodo_Inicial,Nodo_Final,camino="";
    HashMap<String,Integer> listacostos=new HashMap<>();
    HashMap<String,Integer> listafinal=new HashMap<>();
    ArrayList<Lineas> largo=new ArrayList<>();
    ArrayList<Lineas> corto=new ArrayList<>();
    
    public OSPF(String Nodo_Inicial,String Nodo_Final){
        OSPF.Nodo_Final=Nodo_Final;
        OSPF.Nodo_Inicial=Nodo_Inicial; 
    }
    
    public void ospf(int n,String nodo){
       NodosFactory.getNodo(nodo).getNodosApuntadores().forEach((a)->{
           int costo;
           costo=NodosFactory.getNodo(nodo).getCosto(a);
           listacostos.put(a+"->"+nodo, n+costo);
           
           if(!a.equals(Nodo_Final)){
            ospf(n+costo,a);
           }
           else{ 
            if(!listafinal.containsKey(a+"->"+nodo) || listafinal.get(a+"->"+nodo)>n+costo)
                listafinal.put(a+"->"+nodo, n+costo);   
           
           }
       });
    }
    static int costomayor,costomenor;
    
    private String getMayor(){
        String s="",iterator="";
        costomayor=0;
        for (Iterator<String> it = listafinal.keySet().iterator(); it.hasNext();) {
            iterator=it.next();
            if(costomayor<listafinal.get(iterator)){
                costomayor=listafinal.get(iterator);
                s=iterator;
            }    
        }
        return s; 
    }
    
    
    public void LineasCorto(){
        corto.clear();
        if(getMenor() != null||!getMenor().equals("")){
            camino="";
        String st=(Nodo_Final+","+getCaminoNodos(getMenor())); 
        String[] array=st.split(",");
        Collections.reverse(Arrays.asList(array));
        int c=0;
            costoscorto="";
            costoscorto+="El MENOR Costo es de "+costomenor+"\n";
            System.out.println("El MENOR Costo es de "+costomenor);
        for(int x=0;x<array.length-1;x++){
            if(NodosFactory.IDexist(array[x])&&NodosFactory.IDexist(array[x+1])){
                c+=NodosFactory.getNodo(array[x]).getCosto(array[x+1]);
                System.out.println("De '"+array[x]+"' A '"+array[x+1]+"' tiene un costo de "+c);
                costoscorto+="De '"+array[x]+"' a '"+array[x+1]+"' tiene un costo de "+c+"\n";
                corto.add(new Lineas(NodosFactory.getNodo(array[x]).getLocation(),
                    NodosFactory.getNodo(array[x+1]).getLocation(),
                    4));  
            }    
        }
        }
        
    }
    
    public ArrayList<Lineas> getLineasCorto(){
        return corto;
    }
    static String costoslargo ="";
    static String costoscorto ="";
    
    
    public ArrayList<Lineas> getLineasLargo(){
        return largo;
    }
    
    
    private String getMenor(){
        String s="",iterator="";
        costomenor=Integer.MAX_VALUE;//listafinal.get(getMayor());
        for (Iterator<String> it = listafinal.keySet().iterator(); it.hasNext();) {
            iterator=it.next();
            if(listafinal.get(iterator)<costomenor){
                costomenor=listafinal.get(iterator);
                s=iterator;
            }    
        }
        return s; 
    }
    
    
    /*private void eliminarMayor(HashMap hm,String idkey,int costo){
        Iterator it = hm.keySet().iterator();
        String key; 
        while(it.hasNext()){
            key = (String) it.next();
             if(key.contains(idkey)&&(int)hm.get(key)>costo)
            {   
                hm.remove(key);
                break;
            } 
        }
    }*/
    private String getCaminoNodos(String id){
        String[] s={""};
        s=id.split("->");
        
        if(s[1].equals(Nodo_Inicial)){
            camino+=s[1];
            listacostos.remove(id);
            return camino;
        }    
        else {
            camino+= s[1]+",";
            listacostos.remove(id);
            return getCaminoNodos(getKeyContains(listacostos, s[1]+"->"));
        }    
    }
    
  
    
    private String getKeyContains(HashMap hm,String keyContains){
         Iterator it = hm.keySet().iterator();
        String key; 
        String i="";
        while(it.hasNext()){
            key = (String) it.next();
             if(key.contains(keyContains))
            {   
                i=key;
                //System.out.println("k="+i);
                break;
            } 
        }
        return i;
    }
    
  
    
}
