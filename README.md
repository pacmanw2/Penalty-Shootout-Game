# Penalty-Shootout-Game
Game that replicates a FIFA penalty shootout

This game will be able to load teams and players from a file, creating an entire tournament of X number of teams (must be an even number of teams). Each team will be randomly grouped with 3 other teams. Meaning there are 4 teams in each group. Each team will play each other team in their group twice. After all group games are played, the top two teams of each group will advance to the Knock-out/playoffs stage of the tournament. Teams are ranked by these rules.

1. Most points earned
  - Points are earned by wins and ties. A win is worth 3 points, a tie is worth 1, and a loss is worth 0.
2. Wins
3. Most goal difference (goals scored - goals against)
4. Most goals scored
5. Fewest games played
6. Case-Insensitive Lexigraphical Order

In the Knockout stage of the tournament, teams are randomly drawn in the first round. For example, if there are 16 teams in the knockout stage, they would be randomly drawn for the Round of 16 (first knockout round), which will create a bracket used for the remainder of the tournament. After each round, half of the teams will be eliminated. For example if the knockout stage starts with 16 teams, 16 -> 8 -> 4 -> 2, where the 2 last teams would play in the final match. The winner of the final match will be the champion of the tournament. 
