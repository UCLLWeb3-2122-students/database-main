-- EEN teamgenoot voert deze code uit

-- vervang naam van schema door je eigen groepsnaam
-- groep102 staat voor groep1-1

-- vervang local_r012345 door je eigen r-nummer

-- vergeet je teamgenoot geen grants te geven, cfr grants aan lectoren

CREATE SCHEMA groep102;

GRANT ALL ON SCHEMA groep102 TO local_r012345;

CREATE SEQUENCE groep102.animal_id_seq;

GRANT ALL ON SEQUENCE groep102.animal_id_seq TO local_r012345;

CREATE TABLE groep102.animal
(   id integer NOT NULL DEFAULT nextval('groep102.animal_id_seq'::regclass),
    name character varying COLLATE pg_catalog."default" NOT NULL,
    type character varying COLLATE pg_catalog."default",
    food integer,
    CONSTRAINT animal_pkey PRIMARY KEY (id, name)
);

GRANT ALL ON TABLE groep102.animal TO local_r012345;

INSERT INTO groep102.animal ("name","type","food") values ('Blub','vis',5);
INSERT INTO groep102.animal ("name","type","food") values ('Mia','kat',7);

-- grant aan lectoren
GRANT ALL ON SCHEMA groep102 TO local_u0015529;
GRANT ALL ON SEQUENCE groep102.animal_id_seq TO local_u0015529;
GRANT ALL ON TABLE groep102.animal TO local_u0015529;

GRANT ALL ON SCHEMA groep102 TO local_u0034562;
GRANT ALL ON SEQUENCE groep102.animal_id_seq TO local_u0034562;
GRANT ALL ON TABLE groep102.animal TO local_u0034562;


