ALTER TABLE public.movie_session ALTER COLUMN "date" TYPE timestamp USING "date"::timestamp;
ALTER TABLE public.movie_session RENAME COLUMN "date" TO "timestamp";

ALTER TABLE public.movie_session ALTER COLUMN film_id TYPE int8 USING film_id::int8;

