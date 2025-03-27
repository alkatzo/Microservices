Start container :

sroot@DESKTOP-3998JH9:/mnt/c/Users/AlexanderKatz/Projects/Microservices/postgres> docker-compose up


Attach to running container with psql and orderdb database as postgres :
docker exec -it postgres_container psql -U postgres -d orderdb

Add user orderuser and grant permissions to orderdb table

1. Connect to PostgreSQL
   If you're inside the PostgreSQL container, run:

psql -U postgres
Or if you're connecting from outside (assuming PostgreSQL is exposed on port 5432):

psql -h localhost -p 5432 -U postgres -d postgres
2. Create the Role (orderuser)
   Run the following SQL command inside psql:

CREATE ROLE orderuser WITH LOGIN PASSWORD 'Aa123456';
This creates a new user (orderuser) with a password.

3. Grant Permissions on orderdb
   Switch to the orderdb database:

\c orderdb
Grant the necessary privileges:

GRANT CONNECT ON DATABASE orderdb TO orderuser;
GRANT USAGE ON SCHEMA public TO orderuser;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO orderuser;
GRANT USAGE, SELECT, UPDATE ON ALL SEQUENCES IN SCHEMA public TO orderuser;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO orderuser;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT USAGE, SELECT, UPDATE ON SEQUENCES TO orderuser;
4. Allow Table Creation (If Needed)
   If you also want orderuser to be able to create new tables in the public schema:

GRANT CREATE ON SCHEMA public TO orderuser;