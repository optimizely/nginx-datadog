#[derive(Debug)]
pub enum Error {
    Json(serde_json::Error),
    UnsupportedMajorVersion(u32),
}

impl Error {
    pub fn code(&self) -> u8 {
        match self {
            Error::Json(_) => 1,
            Error::UnsupportedMajorVersion(_) => 2,
        }
    }
}

impl std::error::Error for Error {
    fn source(&self) -> Option<&(dyn std::error::Error + 'static)> {
        match self {
            Self::Json(error) => Some(error),
            _ => None,
        }
    }
}

impl std::fmt::Display for Error {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        match self {
            Error::Json(cause) => write!(f, "JSON error: {cause}"),
            Error::UnsupportedMajorVersion(version) => {
                write!(f, "Unsupported major version {version}")
            }
        }
    }
}
