using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */  
    int size = 0, index = 0;
    cin >> size;
    int* arr =  new (nothrow) int[size];
    
    for (index = 0; index < size; index++){
        scanf("%d",(arr+index));
    }
    
    for (index = size - 1; index > -1; index--){
        printf("%d ",*(arr+index));
    }
    return 0;
}
