corr=../ddl/correct/correct0.sql
mv ../ddl/hsout.correct.sql $corr
l=`grep -m1 -n "create table" $corr | cut -d: -f1`
out=../../src/ir/viratech/pond_ms/core/db/flyway/migrations/V1__FirstSchema.sql
head -3 $out > tempfile
tail +$l $corr >> tempfile
mv tempfile $out
