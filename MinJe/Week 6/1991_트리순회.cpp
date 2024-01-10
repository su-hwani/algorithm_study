#include <iostream>

using namespace std;

class node{
public:
    char value;
    node* left;
    node* right;
};

void preorder(node* rt){
    if (rt->value < 'A' || rt->value > 'Z') return;
    cout << rt->value;
    preorder(rt->left);
    preorder(rt->right);
}

void inorder(node* rt){
    if (rt->value < 'A' || rt->value > 'Z') return;
    inorder(rt->left);
    cout << rt->value;
    inorder(rt->right);
}

void postorder(node* rt){
    if (rt->value < 'A' || rt->value > 'Z') return;
    postorder(rt->left);
    postorder(rt->right);
    cout << rt->value;
}

int main(){
    int nodeNum;
    cin >> nodeNum;

    node _node[26];
    for (int i = 0; i < nodeNum; i++){
        _node[i].value = i+'A';
        _node[i].left = nullptr;
        _node[i].right = nullptr;
    }
    
    for (int i = 0; i < nodeNum; i++){
        char v, l, r;
        cin >> v >> l >> r;
        _node[v-'A'].value = v;
        _node[v-'A'].left = &_node[l-'A'];
        _node[v-'A'].right = &_node[r-'A'];
    }
    
    preorder(&_node[0]);
    cout << endl;
    inorder(&_node[0]);
    cout << endl;
    postorder(&_node[0]);
}