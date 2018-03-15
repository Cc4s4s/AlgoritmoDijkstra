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
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Salvador Vera Franco 
 *  OSPF class 1.0
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
         //  eliminarMayor(listacostos,"->"+nodo,costo);
          // if(getValueContains(listacostos, "->"+nodo)>costo||!isKeyContains(listacostos, "->"+nodo))
            listacostos.put(a+"->"+nodo, n+costo);
           
           if(!a.equals(Nodo_Final))
            ospf(n+costo,a);
           else 
            listafinal.put(a+"->"+nodo, n+costo);   
       });
    }
    
    private String getMayor(){
        String s="",iterator="";
        int old=0;
        for (Iterator<String> it = listafinal.keySet().iterator(); it.hasNext();) {
            iterator=it.next();
            if(old<listafinal.get(iterator)){
                old=listafinal.get(iterator);
                s=iterator;
            }    
        }
        return s; 
    }
    
    public ArrayList<Lineas> getLineasCorto(){
        return corto;
    }
    
    public void LineasCorto(){
        corto.clear();
        if(getMenor() != null||!getMenor().equals("")){
            camino="";
        String st=(Nodo_Final+","+getCaminoNodos(getMenor())); 
        String[] array=st.split(",");
        for(int x=0;x<array.length-1;x++){
            if(NodosFactory.IDexist(array[x])&&NodosFactory.IDexist(array[x+1]))
            corto.add(new Lineas(NodosFactory.getNodo(array[x]).getLocation(),
                    NodosFactory.getNodo(array[x+1]).getLocation(),
                    4));  
        }
        }
        
    }
    
    public void LineasLargo(){
        largo.clear();
        String st="";
        /*System.out.println("ALL");
        listacostos.keySet().forEach((a)->{
            System.out.println(a+","+listacostos.get(a));
        });*/
        if(getMayor()!= null||!getMayor().equals("")){
            camino="";
            st=(Nodo_Final+","+getCaminoNodos(getMayor())); 
            //System.out.println("C mayor "+st);
        String[] array=st.split(",");
        //System.out.println("Leng Mayor "+array.length);
        for(int x=0;x<array.length-1;x++){
            if(NodosFactory.IDexist(array[x])&&NodosFactory.IDexist(array[x+1]))
            largo.add(new Lineas(NodosFactory.getNodo(array[x]).getLocation(),
                    NodosFactory.getNodo(array[x+1]).getLocation(),
                    4));  
        }
        }
    }
    
    public ArrayList<Lineas> getLineasLargo(){
        return largo;
    }
    
    
    private String getMenor(){
        String s="",iterator="";
        int old=listafinal.get(getMayor());
        for (Iterator<String> it = listafinal.keySet().iterator(); it.hasNext();) {
            iterator=it.next();
            if(listafinal.get(iterator)<old){
                old=listafinal.get(iterator);
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
        
        System.out.println("Recivido "+id);
        if(s[1].equals(Nodo_Inicial)){
            camino+=s[1];
            listacostos.remove(id);
            System.out.println(camino);
            return camino;
        }    
        else {
            camino+= s[1]+",";
            listacostos.remove(id);
            System.out.println(camino);
            return getCaminoNodos(getKeyContains(listacostos, s[1]+"->"));
        }    
    }
    
    private int getValueContains(HashMap hm,String keyContains){
         Iterator it = hm.keySet().iterator();
        String key; 
        int i=-1;
        while(it.hasNext()){
            key = (String) it.next();
             if(key.contains(keyContains))
            {   
                i=(int)hm.get(key);
                break;
            } 
        }
        return i;
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
    
    private boolean isKeyContains(HashMap hm,String keyContains){
         Iterator it = hm.keySet().iterator();
        String key; 
        boolean i=false;
        while(it.hasNext()){
            key = (String) it.next();
             if(key.contains(keyContains))
            {   
                i=true;
                break;
            } 
        }
        return i;
    }
    
   /* public void buscar(){
        System.out.println(Nodo_Final+","+getCaminoNodos(getMayor()));
        camino=Nodo_Final+",";
        System.out.println("Menor "+getMenor());
        System.out.println(getCaminoNodos(getMenor()));
        
        
    }*/
    
}
