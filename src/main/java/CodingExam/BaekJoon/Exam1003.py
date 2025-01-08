def fibonacci(num):
    dp = [(1, 0), (0, 1)];
    for i in range(2, num + 1):
        zero = dp[i - 1][0] + dp[i - 2][0];
        one = dp[i - 1][1] + dp[i - 2][1];
        dp.append((zero, one));

    return dp[num];

T = int(input());
for _ in range(T):
    num = int(input());
    result = fibonacci(num);
    print(result[0], result[1]);