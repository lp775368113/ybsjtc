 
   mini.parse();   
   var qx = mini.get('qx'); 
   var xq = mini.get('xq'); 
   function oncw_QxChanged2() { 
   xq.setValue(''); 
   var   url='../../../zddm/listZddm.do?fdmz='+qx.getValue() ;
   xq.setUrl(url);  
   mini.get('area_id').setValue(qx.getValue()); 
   }
   
   function oncw_XQChanged2() {
   mini.get('area_id').setValue(xq.getValue());
   }
 
   
   function oncw_QxChanged() { mini.get('"+this.paramField+"').setValue(qx.getValue());  }
   
   
   
   