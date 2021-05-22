#include <iostream>

#include <vector>

using namespace std;

void input(vector<int> &arr)
{
    for (int i = 0; i < arr.size(); i++)
    {
        cin >> arr[i];
    }
}

void print(vector<int> &arr)
{
    for (int i = 0; i < arr.size(); i++)
    {
        cout << arr[i] << " ";
    }
    cout << endl;
}

vector<int> mergeTwoSortedArrays(vector<int> &A, vector<int> &B)
{
    if (A.size() == 0 || B.size() == 0)
        return A.size() == 0 ? B : A;

    int n = A.size();
    int m = B.size();
    vector<int> ans(n + m, 0);

    cout << ("Merging these two arrays ") << endl;
    cout << ("left array -> ");
    print(A);
    cout << ("right array -> ");
    print(B);

    int i = 0, j = 0, k = 0;
    while (i < n && j < m)
    {
        if (A[i] < B[j])
            ans[k++] = A[i++];
        else
            ans[k++] = B[j++];
    }

    while (i < n)
        ans[k++] = A[i++];
    while (j < m)
        ans[k++] = B[j++];

    return ans;
}

vector<int> mergeSort(vector<int> &arr,int lo,int hi)
{
    if(lo == hi){
        vector<int> base(1,0);
        base[0]=arr[lo];
        return base;
    }
    vector<int> a=mergeSort(arr,lo,(lo+hi)/2);
    vector<int> b=mergeSort(arr,(lo+hi)/2+1,hi);
    
    return mergeTwoSortedArrays(a,b);
}

int main()
{
    int n, m;
    cin >> n;
    vector<int> A(n, 0);
    input(A);

    vector<int> ans = mergeSort(A,0,A.size()-1);
    cout << "Sorted Array -> ";
    print(ans);
    return 0;
}