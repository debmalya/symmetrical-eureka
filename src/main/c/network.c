#include <stdio.h>

int main()
{
 char h[]="hac\0ker";
 int i=0;
 for(; h[i] ;)
 {
  printf("\n%c%c%c%c",*&h[i],*(*&h+i),*(i+&*h),i[*&h]);
   i++;
 } }
