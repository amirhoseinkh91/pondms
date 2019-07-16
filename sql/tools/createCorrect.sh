cd ../ddl/correct
maxNum=0
for file in correct*.sql
do
  temp=${file%.sql}
  num=${temp#correct}
  [[ $num -gt $maxNum ]] && maxNum=$num    
done

((maxNum++)) 

cd ..
echo generating correct$maxNum
../tools/corrector_x64 < hsout.sql > correct/correct$maxNum.sql
