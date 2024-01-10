#include <iostream>
#include <vector>
#include <stack>
using namespace std;

void dfs(vector<int> graph[], bool visited[], int start)
{
    stack<int> s;
    s.push(start);
    visited[start] = true;
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
                
                break;
            }
        }
    }
}

int main()
{
    int n,m;
    cin >> n >> m;

    vector<int> graph[n+1];
    bool visited[1001] = {false};

    for (int i = 0 ; i < m ; i++)
    {
        int u,v;
        cin >> u >> v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }
    int cnt = 0;
    for(int i = 1 ; i <= n ; i++)
    {
      if (!visited[i])
      { cnt++;
        dfs(graph, visited, i);
      }
    }
    cout << cnt << endl;
}