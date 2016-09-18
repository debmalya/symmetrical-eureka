#include <stdio.h>
#include <string.h>
#include <stdlib.h>



int main()
{
    int T = 0;
    scanf("%d",&T);
    int *r;
    char buffer[20];
    int t[T];
    for (int i = 0; i <T; i++){
    	scanf("%d",&t[i]);
    }
    
   
    int count = 0;
    int factor_count = 0;
    for (int i = 0; i < T; i++){
    	//int r[t[i]];
    	r = (int*) calloc(t[i], sizeof(int));
    	memset(r, 0, t[i]*sizeof(int));
    	
    	
    	
    	for (int j = 2; j  < t[i]; j++){
    		int num = j;
    		
    		for (int k = 2; k < j; k++){
    			int sub_count = 0;
    			
    			while (num % k == 0){
    				
    				if (sub_count > 0) {
    					count++;
    					*(r+j)=j;
    				
    					break;
    				}
    				num /= k;
    				sub_count++;
    			}
    		}
    		
    	}
    	
    	printf("%d\n",(count*2));
    	for (int k = 0; k < t[i]; k++){
    		if (*(r+k)!=0) {
    			printf("%d ",*(r+k));
    		}
    	}
    		
    	
    	free(r);
    }
   	
    return 0;
}
