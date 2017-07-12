#!/bin/python3

import sys

def migratoryBirds(n, ar):
    # Complete this function
    ar.sort()
    c=0
    max=0
    maxNumber=0
    prev=ar[0]
    for counter in range(1,n-1):
        if prev == ar[counter]:
            c=c+1
        else:
            if c > max:
                max =c
                maxNumber=prev
            c=0
        prev=ar[counter]
    if c > max:
        maxNumber=prev
    return maxNumber    
            

n = int(input().strip())
ar = list(map(int, input().strip().split(' ')))
result = migratoryBirds(n, ar)
print(result)

