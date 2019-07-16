#!/bin/bash
export PGPASSWORD=root
psql -h localhost -U viratech -d PondMS -f dropAllTables.sql

cd ../ddl/correct
maxNum=0
for file in correct*.sql
do
  temp=${file%.sql}
  num=${temp#correct}
  if [ $num -gt $maxNum ]; then
    maxNum=$num    
  fi
done

cd ..
echo "running correct$maxNum.sql"
 
psql -h localhost -U viratech -d PondMS -f ../ddl/correct/correct$maxNum.sql
