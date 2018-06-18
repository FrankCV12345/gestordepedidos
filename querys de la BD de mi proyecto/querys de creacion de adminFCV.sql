 create tablespace tsp_fcv 
   datafile 'C:\oraclexe\app\oracle\oradata\XE\tsp_fcv .dbf' size 5M 
   autoextend on next 200k maxsize 5500K ; 

create user adminFCV identified by entrada38
   default tablespace tsp_fcv
   quota 5000k on tsp_fcv ;
  
 grant create session to adminFCV; 
 grant dba to adminFCV;

