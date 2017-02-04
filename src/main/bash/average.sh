read N
c=1
total=0
while [ $c -le $N ]
do
    read each
	((total=total+each))
    (( c++ ))
done
bc <<< "scale = 3; $total/$N"
#printf "%.3f" 3 $total
#printf "%.3f" $(echo $sum/$n | bc -l)
