ALTER SESSION SET "_Oracle_Script"=TRUE;

CREATE USER PETS_BD 
IDENTIFIED BY "PETS2024."
DEFAULT TABLESPACE DATA
TEMPORARY TABLESPACE TEMP
QUOTA UNLIMITED ON DATA;

GRANT CREATE SESSION, RESOURCE TO PETS_BD;

ALTER USER PETS_BD 
DEFAULT ROLE RESOURCE;

