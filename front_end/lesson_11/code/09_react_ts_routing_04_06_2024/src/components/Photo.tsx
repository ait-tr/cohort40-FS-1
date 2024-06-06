import { FC } from 'react'
import { IPhotoJson } from './PhotoList'

const Photo: FC<{photo: IPhotoJson}> = ({ photo }) => {
  return (
    <div>
        <img src={photo.thumbnailUrl} alt={photo.title} />
        <h2>{photo.title}</h2>
    </div>
  )
}

export default Photo