-- Table: airports

-- DROP TABLE airports;

CREATE TABLE airports
(
  id serial NOT NULL,
  icao character(4) NOT NULL,
  iata character(3),
  latitude numeric(16,8),
  longitude numeric(16,8),
  full_name character varying(512),
  CONSTRAINT airp_pk PRIMARY KEY (id),
  CONSTRAINT airp_icao_uq UNIQUE (icao)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE airports
  OWNER TO ff;
  
-- Table: airlines

-- DROP TABLE airlines;

CREATE TABLE airlines
(
  id serial NOT NULL,
  code character(6) NOT NULL,
  name character varying(512),
  country character varying(255),
  CONSTRAINT airl_pk PRIMARY KEY (id),
  CONSTRAINT airl_code_uq UNIQUE (code)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE airlines
  OWNER TO ff;


-- Table: flights

-- DROP TABLE flights;

CREATE TABLE flights
(
  id serial NOT NULL,
  departure character(4) NOT NULL, -- as icao
  destination character(4) NOT NULL, -- as icao
  airline_id integer NOT NULL,
  std timestamp without time zone NOT NULL,
  sta timestamp without time zone NOT NULL,
  code character varying(200),
  duration numeric(11,0),
  CONSTRAINT fli_pk PRIMARY KEY (id),
  CONSTRAINT fli_airl_fk FOREIGN KEY (airline_id)
      REFERENCES airlines (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fli_dep_fk FOREIGN KEY (departure)
      REFERENCES airports (icao) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fli_dest_fk FOREIGN KEY (destination)
      REFERENCES airports (icao) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE flights
  OWNER TO ff;
COMMENT ON COLUMN flights.departure IS 'as icao';
COMMENT ON COLUMN flights.destination IS 'as icao';




  

