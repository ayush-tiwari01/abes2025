#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;


bool isPrime(int num) {
    if (num <= 1) return false;
    if (num == 2) return true;
    if (num % 2 == 0) return false;  
    for (int i = 3; i <= sqrt(num); i += 2) {
        if (num % i == 0) return false;
    }
    return true;
}

vector<int> rearrangeArray(vector<int>& arr) {
    vector<int> primes;
    vector<int> nonPrimes;

    for (int num : arr) {
        if (isPrime(num)) {
            primes.push_back(num);
        } else {
            nonPrimes.push_back(num);
        }
    }

 
    sort(primes.begin(), primes.end(), greater<int>());
    sort(nonPrimes.begin(), nonPrimes.end(), greater<int>());

    vector<int> result;

   
    if (!primes.empty()) {
        result.push_back(primes.front());
        primes.erase(primes.begin());
    }

    
    result.insert(result.end(), nonPrimes.begin(), nonPrimes.end());

    if (!primes.empty()) {
        result.push_back(primes.back());
    }

    return result;
}

int main() {
    vector<int> arr1 = {1, 8, 11, 2, 5};  

    
    vector<int> result1 = rearrangeArray(arr1);

   
    cout << "Rearranged Array 1: ";
    for (int num : result1) {
        cout << num << " ";
    }
    cout << endl;

    return 0;
}
