DIR=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )
ant -f $DIR/../../build.xml corrector -DinputFile=$(readlink -f $1) -DoutputFile=$(readlink -f $2)