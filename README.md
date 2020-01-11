# TASystem-Java-

A Java program that models a Technical Analysis System. Uses multiple running threads to mathematically analyze stocks using multiple factors. Stock information is read from a text file (currently named SP500.txt).

Number of days to be used in the moving average is specified by the user.

Output is in both raw numerical and sentence format. 
Example output for input parameter of 5 days:
- - - - - - - - - - - - - - - -
2826.060059, 2802.389893, 2783.02002, 2788.860107, 2752.060059, 

EMA: 2813.8312261337

px for SP500, 2752.060059, is 3.0385854456467096 std dev below moving average, 2804.5140137999997

MA: 2790.4780275999997

sDev: 24.257589952995964
- - - - - - - - - - - - - - - -
Supported stock analysis results: Exponential Moving Average, Moving Average, Standard Deviation
