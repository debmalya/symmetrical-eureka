#include <stdio.h>

int main(){
	int a[10];
	int *a1 = a;

	printf("%ld\n",sizeof(a));
	printf("%ld\n",sizeof(a1));
}
