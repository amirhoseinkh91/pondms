#!/bin/bash
export PGPASSWORD=root

cd ../initialData/correct
maxNum=0
for file in initialData_correct*.sql
do
  temp=${file%.sql}
  num=${temp#initialData_correct}
  if [ $num -gt $maxNum ]; then
    maxNum=$num    
  fi
done

cd ..
echo "running initialData_correct$maxNum.sql"

psql -h localhost -U viratech -d PondMS -f ../initialData/correct/initialData_correct$maxNum.sql
