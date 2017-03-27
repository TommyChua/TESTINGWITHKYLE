
public class RobotControl {
	   private Robot r;
	   public RobotControl(Robot r)
	   {
	       this.r = r;
	   }

	   public void control(int barHeights[], int blockHeights[])
	   {

	     // Internally the Robot object maintains the value for Robot height(h), arm-width (w) and picker-depth (d).
	     // These values are displayed for your convenience
	     // These values are initialised as h=2 w=1 and d=0
	     // When you call the methods up() or down() h will be changed	
	     // When you call the methods extend() or contract() w will be changed	
	     // When you call the methods lower() or raise() d will be changed	


		     int h = 5;			// Initial height of arm 1
		     int w = 6;			// Initial width of arm 2  
		     int d = 0;			// Initial depth of arm 3

		     
		     int targetHt1 = 0;    	// Initially empty
		     int targetHt2 = 0;    	// Initially empty
		     int targetHt3 = 0;    	// Initially empty
		     	       
		     int maxBar=0;
		     int maxBlock =0;
		     int sumNumberofBlocks=0;
	         int counter=0;
	         int extendArm2 =10;
	     
	     for (int i = 0; i < barHeights.length; i++)
         {
              if (barHeights[i] > maxBar)//This will check which bar is the highest.
              {
               maxBar = barHeights[i];
              }
         }
         
       
         
         for (int i = 0; i < blockHeights.length; i++)
         {
              sumNumberofBlocks = sumNumberofBlocks + blockHeights[i];//This will check which block is the highest.
              
              if (blockHeights[i] > maxBlock)
              {
               maxBlock = blockHeights[i];
              
              
              }
              
              
         }
         
         int sourceHTQ3 = sumNumberofBlocks;
         
    
         
         while ( h <= maxBar+maxBlock)// maxBar=Maxblock will let the robot know whether how much it should go r.up()
         {
            
             r.up();
              h++;
                        
         }
         
         while (h<=sumNumberofBlocks)//double check the blockheight just in case bar is higher than Block
         {
             r.up();
              h++;
         }
        
         while ( w < extendArm2 )// w intially = 1. This statement will read 8 times . 
         {
             r.extend();
             w++;
         }
         
         while ( h - d > sourceHTQ3 + 1 )//value of h currently =13. This statement show 10-0>sumArrry{blockHeight}+1
         {
             r.lower();
             d++;
         }
         
         r.pick();
        
         int blockHt = blockHeights[blockHeights.length-1];// This is to count the number of blockhehight left
       
         sourceHTQ3 -= blockHt;  //sumArrary=sumArrary-blockHt     
         
         while ( d > 0 )
         {
             r.raise();
             d--;
         }
         
         int targetWidth = blockHeights[blockHeights.length-1];//This will read whether at where the block will be pick . 
         while ( w > targetWidth)
         {
             r.contract();
             w--;
         }

         if (targetWidth == 3 )
         {
         while ( h - d - blockHt  > targetHt3 +1 )
         {
             r.lower();
             d++;
             
         }
         targetHt3 = targetHt3 +3;
         }
         else if (targetWidth == 2)
         {
             while ( h - d - blockHt  > targetHt2 +1 )
             {
             r.lower();
             d++;
            
             }
             targetHt2 = targetHt2 +2;
         }
         else if (targetWidth ==1)
         {
            
             while ( h - d - blockHt  > targetHt1 +1 )
             {
             r.lower();
             d++;
            
             
            
             }
             targetHt1 = targetHt1 +1;
            
         }
         
         r.drop();
         
//         Main  loop(Nested loop)
        
         for (counter = blockHeights.length-2; counter>=0; counter--)
         {       
             
         while ( d > 0 )
         {
             r.raise();
             d--;
         }
         
         while ( w < extendArm2 )
         {
             r.extend();
             w++;
         }
         
         while ( h - d > sourceHTQ3 + 1 )
         {
             r.lower();
             d++;
         }
         
         r.pick();
          blockHt = blockHeights [counter];      // read the top most current height
          
          sourceHTQ3 -= blockHt;   // sumArray=sumArray-blockHt
          
         while ( d > 0 )
         {
             r.raise();
             d--;
         }
         
          targetWidth = blockHeights[counter]; 
         while ( w > targetWidth)
         {
             r.contract();
             w--;
         }
         
         if (targetWidth == 3 )
         {
        	 
         while ( h - d - blockHt  > targetHt3 +1 )
         {
             r.lower();
             d++;
             
             
         }
         targetHt3 = targetHt3 +3;
         }
         else if (targetWidth == 2)
         {
             while ( h - d - blockHt  > targetHt2 +1 )
             {
             r.lower();
             d++;
            
             }
             targetHt2 = targetHt2 +2;
         }
         else if (targetWidth ==1)
         {
             
             while ( h - d - blockHt  > targetHt1 +1 )
             {
             r.lower();
             d++;
            
             
             
             }
             targetHt1 = targetHt1 +1;
            
         }
        
         r.drop();
         }
        
         
         
  
   }


	        	
	        
	   }
	  

	   

	   

