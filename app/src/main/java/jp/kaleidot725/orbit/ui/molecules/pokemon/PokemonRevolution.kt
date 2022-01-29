package jp.kaleidot725.orbit.ui.molecules.pokemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import jp.kaleidot725.orbit.R
import jp.kaleidot725.orbit.data.entity.PokemonDetails
import jp.kaleidot725.orbit.ui.SAMPLE_POKEMON_DETAILS

@Composable
fun PokemonRevolution(details: PokemonDetails, modifier: Modifier = Modifier) {
    val painter = rememberImagePainter(details.pokemon.img) {
        crossfade(200)
        error(R.drawable.ic_error)
        placeholder(
            if (isSystemInDarkTheme()) {
                R.drawable.ic_question_white
            } else {
                R.drawable.ic_question_black
            }
        )
    }

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        elevation = 4.dp
    ) {
        Row(modifier = Modifier.height(50.dp)) {
            Image(
                contentDescription = null,
                contentScale = ContentScale.Fit,
                painter = painter,
                modifier = Modifier
                    .size(50.dp)
                    .padding(start = 16.dp)
            )

            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = details.pokemon.name,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .wrapContentHeight()
                        .padding(start = 16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun PokemonRevolution_Preview() {
    PokemonRevolution(
        details = SAMPLE_POKEMON_DETAILS
    )
}