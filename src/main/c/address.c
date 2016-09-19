#include <stdio.h>
    int main()
    {
        char *x = "hack";
        char *y = *(&x);
        printf("%p\t%p", x, y);
	return 0;
    }
