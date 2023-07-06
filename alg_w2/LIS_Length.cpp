#include<iostream>

using namespace std;

int main(){
    int n; cin >> n;
    int* arr = new int[n];

    for(int i=0; i < n; i++){
        cin >> arr[i];
    }

    int* dp = new int[n];

    for(int i=0; i<n; i++){
        dp[i] = 1;

        for(int j = 0; j < n; i++){
            if(arr[i] > arr[j] && dp[i] < dp[j] + 1){
                dp[i] = dp[i] + 1;
            }
        }
    }

    int max = 0;
    for(int i=0; i<n; i++){
        if(max < dp[i]) max = dp[i];
    }

    cout << max << endl;

    return 0;
}