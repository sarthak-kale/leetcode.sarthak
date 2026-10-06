void reverse(int* nums, int left, int right)
{
    while (left < right) 
    {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        left++;
        right--;
    }
}
void rotate(int* n, int num, int k) 
{
    k = k % num; 
    reverse(n,0,num- 1);
    reverse(n, 0, k - 1);
    reverse(n,k,num- 1);
}
