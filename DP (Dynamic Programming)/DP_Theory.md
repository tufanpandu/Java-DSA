# 👉What is DP ?

> DP is optimized recursion.

# 👉How to identify DP ?

> a. Optimal Problem ( finding specific value maximum , minimum , largest , smallest and list )
> b. Some choise is given(Multiple branches in recursion tree)

# 👉 DP Defination

> Dynamic Programming is a technique in computer programming that help efficiently solve the class of problem that have 'overlapping subproblem ' and 'optimal substructure' propery.

# 👉 Way's of DP(Dynamic Programming).

### a. Momoization (Top Down)

```
1. Recursion
2. Store sub porblem into storage like Array
```

**Example Code solution**

```java
public static int fib(int n , int dp[]){
    //Base Case
    if( n == 0 || n ==1){
        return n;
    }
  int fnm1 = fib(n-1, dp);
  int fnm2 = fib(n-2 , dp);
  //Stor sum value into dp[] array
  dp[n] = fnm1 + fnm2; //This is called Memoiztion
  return dp[n];
}


int n=5;
int dp[] = new int[n+1];
```

### b. Tabulation(Bottom Up)

```
We solve this porblem doing interate(loop).
1.Initialize 0 and 1.
2.Assign meaning to each index.
3.Filing Small to Long.
```

**Example Code Solution**

```java
// n = 5;
public static void tabulationFib(int n){
    //Initialize
    int dp[] = new int[n+1];
     dp[0] =  0;
     dp[1] = 1;
     //Iterate on
    for(int i = 2;i<=n;i++){
        dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
}
```
