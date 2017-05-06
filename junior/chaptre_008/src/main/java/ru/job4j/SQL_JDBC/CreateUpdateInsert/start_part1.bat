set PGPASSWORD=123
psql -U postgres -f user_create.sql
psql -U postgres -f db_create.sql
psql -U postgres -f table_create.sql
psql -U postgres -f fill_table.sql
psql -U postgres -f test_request.sql
