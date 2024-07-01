package ch.tutteli.atrium.reporting

import ch.tutteli.atrium.reporting.reportables.TextElement

/**
 * Use this class to represent a [String] which should be treated as raw [String] in reporting.
 * @see ObjectFormatter
 *
 * @property string The string which should be treated as raw [String].
 * @param string The string which should be treated as raw [String].
 */
//TODO 2.0.0 remove data, change toString, use Text(string)
data class Text private constructor(override val string: String) : TextElement {

    /**
     * @suppress No need to document this behaviour.
     */
    override fun toString(): String {
        return "$string (Text)"
    }

    companion object {

        operator fun invoke(string: String): Text {
            require(string.isNotEmpty()) { "use Text.EMPTY instead" }
            return Text(string)
        }

        /**
         * The representation of `null` as [Text].
         */
        val NULL = Text("null")

        /**
         * An empty string as [Text]
         */
        val EMPTY = Text("")

        /**
         * A provider which returns [EMPTY].
         * @since 1.1.0
         */
        val EMPTY_PROVIDER = { EMPTY }
    }
}
