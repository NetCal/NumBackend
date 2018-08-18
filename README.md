# NumBackend by DiscoDNC

A backend for (immutable) number representations that allows you to switch between different real and rational implementations.

### Limitations

It is currently not possible to mix instances of different implementations. Yet, for performance reasons, only the `equals(Object obj)` methods check for `obj instanceof` and will then simply return `false`. Other methods will simply raise some exception (most probably a cannot cast exception).