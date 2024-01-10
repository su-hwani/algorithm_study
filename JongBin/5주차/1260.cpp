#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <algorithm>
using namespace std;

void dfs(vector<int> graph[], bool visited[], int start)
{
    stack<int> s;
    s.push(start);
    visited[start] = true;
    cout << start << " ";
    while (!s.empty())
    {
        int current = s.top();
        s.pop();
        for (int i = 0 ; i < graph[current].size() ; i++)
        {
            int next = graph[current][i];
            if (!visited[next])
            {
                s.push(current);
                s.push(next);
                visited[next] = true;
                cout << next << " ";
                break;
            }
        }
    }
}

void bfs(vector<int> graph[], bool visited[], int start)
{
    queue<int> q;
    q.push(start);
    visited[start] = true;
    while (!q.empty())
    {
        int current = q.front();
        q.pop();
        cout << current << " ";
        for (int i = 0 ; i < graph[current].size() ; i++)
        {
            int next = graph[current][i];
            if (!visited[next])
            {
                q.push(next);
                visited[next] = true;
            }
        }
    }
}

int main()
{   
    int n, m , start;
    cin >> n >> m >> start;
    vector<int> graph[n+1];
    bool visited[1001] = {false};

    for (int i = 0 ; i < m ; i++)
    {
        int a, b;
        cin >> a >> b;
        //양방향 그래프라 둘다 추가
        graph[a].push_back(b);
        graph[b].push_back(a);        
    }
    for (int i = 1 ; i <= n ; i++)
    {
        sort(graph[i].begin(), graph[i].end());
    }
    dfs(graph, visited, start);
    cout << endl;
    bool visited2[1001] = {false};
    bfs(graph, visited2, start);
    cout << endl;
}