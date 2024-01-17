#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;


int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M;
    cin >> N >> M;
    
    vector<string> notHeard;
    vector<string> notSeen;
    for (int i = 0; i < N; i++){
        string name;
        cin >> name;
        notHeard.push_back(name);
    }
    for (int i = 0; i < M; i++){
        string name;
        cin >> name;
        notSeen.push_back(name);
    }
    sort(notHeard.begin(), notHeard.end());
    sort(notSeen.begin(), notSeen.end());

    vector<string> notHeardSeen (N+M);
    auto it = set_intersection(notHeard.begin(), notHeard.end(), notSeen.begin(), notSeen.end(), notHeardSeen.begin());
    // notHeardSeen.erase(it, notHeardSeen.end());

    cout << notHeardSeen.size() << "\n";
    for(auto itr = notHeardSeen.begin(); itr != notHeardSeen.end(); itr++){
        cout << *itr << "\n";
    }
}